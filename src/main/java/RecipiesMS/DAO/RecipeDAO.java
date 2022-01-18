package RecipiesMS.DAO;

import RecipiesMS.DBconfig.DataSourceProviderTemplate;
import RecipiesMS.JavaModels.Recipe;
import RecipiesMS.JavaModels.Vote;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class RecipeDAO {
    private DataSource dataSource;

    public RecipeDAO(){
        this.dataSource= DataSourceProviderTemplate.getDataSource();
    }

    public List<Recipe> getRecipies(){
        final String querry = """
        SELECT id, title, preptime, ingredients, description FROM recipe ORDER BY id DESC""";
        List<Recipe> recipies = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet set = statement.executeQuery(querry);
            while(set.next()){
                Recipe one = mapper(set);
                recipies.add(one);
            }
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        return recipies;
    }

    private static Recipe mapper(ResultSet set){
        try {
            int id = set.getInt("id");
            String title = set.getString("title");
            int preptime = set.getInt("preptime");
            String ingredients = set.getString("ingredients");
            String description = set.getString("description");
            return new Recipe(id,title,ingredients,description,preptime);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void addRecipe(Recipe recipe){
        final String sql = """
                INSERT INTO recipe (title, preptime, ingredients,description) VALUES (?,?,?,?)""";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1,recipe.getTitle());
            statement.setInt(2,recipe.getPreptime());
            statement.setString(3,recipe.getIngredients());
            statement.setString(4,recipe.getDesciption());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()){
                recipe.setId(generatedKeys.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Integer> findRecipeId(String title){
        final String querry = """
                SELECT id FROM recipe WHERE title = (?)""";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(querry)) {
            statement.setString(1,title);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                int idInt = resultSet.getInt("id");
                Integer id = Integer.valueOf(idInt);
                return Optional.of(id);
            }
            return Optional.empty();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteRecipe(Integer id){
        int idInt = id;
        final String sql = """
                DELETE FROM recipe WHERE id=?""";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1,idInt);
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(!generatedKeys.equals(null)){
                return true;
            }
            return false;
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateOrAddDescription(Integer id, String description) {

        String not ="Bartek";
        String[] notToChange = new String[]{"Bartek", "Robert", "Irek", "Tomek", "Rafał", "Rafal"};
        final String querry0 = """
                SELECT description FROM recipe WHERE id = (?)""";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement0 = connection.prepareStatement(querry0)) {
            statement0.setInt(1,id);
            ResultSet resultSet = statement0.executeQuery();
            if(resultSet.next()){
                String description1 = resultSet.getString("description");
                boolean test = Arrays.stream(notToChange).anyMatch(s -> s.equals(description1));
                if(!test){
                    updateOrAddDescription2(id,description);
                }
//                for(String one : notToChange){
//                    if(one.equals(description1)){
//                        System.out.println("ten sam opis co w tabeli not to change");
//                        boolean stopUpdate = true;
//                        if(!stopUpdate){
//                            updateOrAddDescription2(id,description);
//                        }
//                    }
//                }
            }
//                boolean test = getRecipies().stream().filter(id0 -> id.equals(id0)).map(Recipe::getDesciption).noneMatch(s -> s.equals(not));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateOrAddDescription2(Integer id, String description) {
        final String querry = """
        SELECT description FROM recipe WHERE id=(?)""";
        try (   Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(querry)) {
            statement.setInt(1,id);
            ResultSet set = statement.executeQuery();

            if(!set.equals(null)){
                final String querry2 = """
                UPDATE recipe SET description = (?) WHERE id = (?)""";
                try (   PreparedStatement statement2 = connection.prepareStatement(querry2)) {
                    statement2.setString(1,description);
                    statement2.setInt(2,id);
                    statement2.executeUpdate();
                }}
            else {
                final String querry3 = """
                INSERT INTO recipe(description) values = (?) WHERE id = (?)""";
                try (   PreparedStatement statement3 = connection.prepareStatement(querry3)) {
                    statement3.setString(1,description);
                    statement3.setInt(2,id);
                    statement3.executeUpdate();
                }
            }
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }}


    public void addVote(Vote vote) {
        final String querry = """
                INSERT INTO
                    vote (recipeId, type, dateAdded)
                VALUES
                    (?, ?, ?)
                """;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(querry)) {
            statement.setInt(1, vote.getRecipeId());
            statement.setString(2, vote.getType().toString());
            statement.setObject(3, vote.getDateAdded());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer countVotes(Integer recipeId) {
        final String querry = """
                SELECT
                	(SELECT COUNT(recipeId) FROM vote WHERE recipeId = ? AND type = 'UP')
                    -
                    (SELECT COUNT(recipeId) FROM vote WHERE recipeId = ? AND type = 'DOWN')
                    AS
                    vote_count;
                """;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(querry)) {
            statement.setInt(1, recipeId);
            statement.setInt(2, recipeId);
            ResultSet resultSet = statement.executeQuery();
            Integer counter = 0;
            while (resultSet.next()){
                counter = resultSet.getInt("vote_count");
            }
            return counter;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
package Model;

import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
/**
 * Handles json file reading and writing for movies and user
 */
public class JsonInterface
{

    /**
     * Constructs an array containing all movies from a json file
     * @param jsonfile The string that contains the directory to the movie json file
     * @return A master array for the system to read that conatins all information of movies from json file.
     */
    public static Movie[] buildmasterlist(String jsonfile) throws IOException
    {

        Gson gson = new Gson();
        Movie[] MasterList;

        String content = new String(Files.readAllBytes(Paths.get(jsonfile))); //Movie file
        MasterList = gson.fromJson(content, Movie[].class);
        return MasterList;
    }
    /**
     * Constructs an array containing all users form a json file
     * @param userjson The string that contains the directory to the muser list json file
     * @return A master user list array for the system to handle user logging and collections
     */
    public static User[] getuserlist(String userjson) throws IOException
    {

        Gson gson = new Gson();
        User[] UserList;
        String content = new String(Files.readAllBytes(Paths.get(userjson))); //Movie file
        UserList = gson.fromJson(content, User[].class);
        return UserList;
    }
    /**
     * Writes the user array into a json file
     * @param user The array of users that will be written to a json file
     */
    public static void writeUser(ArrayList<User> users)
    {
        Gson gson = new Gson();

        String json = gson.toJson(users);

        try
        {
            FileWriter writer = new FileWriter("src/MasterUser.json");
            writer.write(json);
            writer.close();


        } catch (IOException e)
        {

            e.printStackTrace();
        }

    }
}

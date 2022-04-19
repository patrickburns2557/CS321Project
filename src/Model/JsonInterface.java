package Model;

import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JsonInterface {
    //array movie (master list)
    //load user
    //save user

public static Movie[] buildmasterlist(String jsonfile) throws IOException {

    Gson gson = new Gson();
    Movie[] MasterList;

    String content = new String(Files.readAllBytes(Paths.get(jsonfile))); //Movie file
    MasterList = gson.fromJson(content, Movie[].class);
    return MasterList;
}
public static User[] getuserlist(String userjson) throws IOException {

    Gson gson = new Gson();
    User[] UserList;
    String content = new String(Files.readAllBytes(Paths.get(userjson))); //Movie file
    UserList = gson.fromJson(content, User[].class);
    return UserList;
}
public void writeUser(ArrayList<User> users)
{
    Gson gson = new Gson();

    String json = gson.toJson(users);

    try {
        FileWriter writer = new FileWriter("src/MasterUser.json");
        writer.write(json);
        writer.close();



    } catch (IOException e){

        e.printStackTrace();
    }

}
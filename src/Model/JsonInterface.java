package Model;

import com.google.gson.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonInterface {
    //array movie (master list)
    //load user
    //save user

public Movie[] buildmasterlist(String jsonfile) throws IOException {

    Gson gson = new Gson();
    Movie[] MasterList;

    String content = new String(Files.readAllBytes(Paths.get(jsonfile))); //Movie file
    MasterList = gson.fromJson(content, Movie[].class);
    return MasterList;
}
public User[] getuserlist(String userjson) throws IOException {

    Gson gson = new Gson();
    User[] UserList;
    String content = new String(Files.readAllBytes(Paths.get(userjson))); //Movie file
    UserList = gson.fromJson(content, User[].class);
    return UserList;
}
public void writeUser(String str)
{

//tentative

}




}

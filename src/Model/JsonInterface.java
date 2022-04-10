package Model;

import com.google.gson.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonInterface {
    //array movie (master list)
    //load user
    //save user
    public static void main(String[] args) throws IOException {

        Gson gson = new Gson();
         Movie[] MasterList;

        String content = new String(Files.readAllBytes(Paths.get("C:\\Users\\M\\Desktop\\SampleMovieFile.json"))); //Movie file
        MasterList = gson.fromJson(content, Movie[].class);


    }


}

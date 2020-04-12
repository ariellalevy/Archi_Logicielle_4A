package com.esiea.tp4A.api.Online;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URLDecoder;
import java.util.*;



import com.esiea.tp4A.api.Api;
import com.esiea.tp4A.code.Obstacle;
import com.esiea.tp4A.domain.Position;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sun.net.httpserver.*;


public final class serverHttp {

    private static ApiOnline api;
    private static int PlayersCount = 0;

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost",8090), 0);
        System.out.println("server started at " + server.getAddress());
        server.createContext("/", new MyHandler());
        server.createContext("/api/player/", new playHandler());
        server.setExecutor(null);
        server.start();
        api = new ApiOnline();
    }

    static class returnedObject {
        Player player;
        LocalMap localMap;
    }

    static  class LocalMap{
        ArrayList<Obstacle> obstacles;
        ArrayList<Player> players;
    }

    static class Player{
        String name;
        enum Status {
            alive,
            dead
        }
        Position position;
        int Laser_range;
    }


    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange he) throws IOException {
            String response = he.getRequestURI().toString();
            he.sendResponseHeaders(200, response.length());
            OutputStream os = he.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

     static class playHandler implements HttpHandler {

        @Override

        public void handle(HttpExchange he) throws IOException {

            switch (he.getRequestMethod()){
                case "GET":
                    getFct(he);
                    break;
                case "POST":
                    postFct(he);
                    break;
                case "PATCH":
                    patchFct(he);
                    break;
                    default:
                        Map<String, Object> parameters = new HashMap<String, Object>();
                        URI requestedUri = he.getRequestURI();
                        String query = requestedUri.getRawQuery();
                        parseQuery(query, parameters);

                        // send response
                        String response = "Action non reconnue" ;
                        he.sendResponseHeaders(403, response.length());
                        OutputStream os = he.getResponseBody();
                        os.write(response.toString().getBytes());
                        os.close();
                        break;
            }
        }
    }

    private static void getFct(HttpExchange he) throws IOException{
        String myQuerry = he.getRequestURI().toString().replace("/api/player/","").replace("{","").replace("}","").replace("%7B","").replace("%7D","");
        // parse request
        Map<String, Object> parameters = new HashMap<String, Object>();
        URI requestedUri = he.getRequestURI();
        String query = requestedUri.getRawQuery();

        parseQuery(query, parameters);
        System.out.println("avant reponse" + myQuerry);
        // send response
        var retour = api.getPlayerData(myQuerry);

        String response = "";

        if (retour != null){
            response = jsonComeBack(retour);
        }else{
            response = "le joeur n'existe pas";
        }
        System.out.println(response);
        he.sendResponseHeaders(200, response.length());
        OutputStream os = he.getResponseBody();
        os.write(response.toString().getBytes());
        os.close();


    }

        private static void postFct(HttpExchange he) throws IOException {
        System.out.println("Post");
            String myQuerry = he.getRequestURI().toString().replace("/api/player/","").replace("{","").replace("}","").replace("%7B","").replace("%7D","");
            // parse request
            Map<String, Object> parameters = new HashMap<String, Object>();
            InputStreamReader isr = new InputStreamReader(he.getRequestBody(), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String query = br.readLine();
            parseQuery(query, parameters);

            // send response
            String response = jsonComeBack(api.joingame(myQuerry));

            he.sendResponseHeaders(200, response.length());
            OutputStream os = he.getResponseBody();
            os.write(response.toString().getBytes());
            os.close();
        }

        private static void patchFct(HttpExchange he) throws IOException{
            String myQuerry = he.getRequestURI().toString().replace("/api/player/","").replace("{","").replace("}","").replace("%7B","").replace("%7D","");
            String[] parts = myQuerry.split("/");
            String part1 = parts[0]; // playerName
            String part2 = parts[1]; // command

            String response = jsonComeBack(api.command(part1,part2));

            he.sendResponseHeaders(200, response.length());
            OutputStream os = he.getResponseBody();
            os.write(response.toString().getBytes());
            os.close();
        }

        private static String jsonComeBack(player Player) throws IOException{
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.createObjectNode();

            JsonNode childNode1 = mapper.createObjectNode();
            ((ObjectNode) childNode1).put("name", Player.getNameJoueur());
            ((ObjectNode) childNode1).put("status", Player.getRoverJoueur().isAlive());
            ((ObjectNode) childNode1).put("laser-range", 1);


            JsonNode childNode12 = mapper.createObjectNode();
            ((ObjectNode) childNode12).put("x", Player.getRoverJoueur().getPosition().getX());
            ((ObjectNode) childNode12).put("y", Player.getRoverJoueur().getPosition().getY());
            ((ObjectNode) childNode12).put("direction", Player.getRoverJoueur().getPosition().getDirection().name());

            ((ObjectNode) childNode1).put("position", childNode12);

            ((ObjectNode) childNode1).set("position", childNode12);



            ((ObjectNode) rootNode).set("player", childNode1);

            JsonNode childNode2 = mapper.createObjectNode();
            ((ObjectNode) childNode2).put("obstacle", (api.getGameObstacles(Player.getNameJoueur())).toString());
            ((ObjectNode) childNode2).put("players", (api.getGamePalyers(Player.getNameJoueur())).toString());


            ((ObjectNode) rootNode).set("local-map", childNode2);

            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
            System.out.println(jsonString);
            return jsonString;
        }

    private static int getPlayersCount(){
        return PlayersCount++;
    }

    public static void parseQuery(String query, Map<String,
        Object> parameters) throws UnsupportedEncodingException {

        if (query != null) {
            String pairs[] = query.split("[&]");
            for (String pair : pairs) {
                String param[] = pair.split("[=]");
                String key = null;
                String value = null;
                if (param.length > 0) {
                    key = URLDecoder.decode(param[0],
                        System.getProperty("file.encoding"));
                }

                if (param.length > 1) {
                    value = URLDecoder.decode(param[1],
                        System.getProperty("file.encoding"));
                }

                if (parameters.containsKey(key)) {
                    Object obj = parameters.get(key);
                    if (obj instanceof List<?>) {
                        List<String> values = (List<String>) obj;
                        values.add(value);

                    } else if (obj instanceof String) {
                        List<String> values = new ArrayList<String>();
                        values.add((String) obj);
                        values.add(value);
                        parameters.put(key, values);
                    }
                } else {
                    parameters.put(key, value);
                }
            }
        }
    }
}

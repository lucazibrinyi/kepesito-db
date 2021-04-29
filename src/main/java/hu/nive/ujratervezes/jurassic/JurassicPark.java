package hu.nive.ujratervezes.jurassic;

import java.sql.*;
import java.util.*;


public class JurassicPark {

    private String dbUrl;
    private String dbUser;
    private String dbPassword;

    public JurassicPark(String dbUrl, String dbUser, String dbPassword) {
        this.dbUrl = dbUrl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    public List<String> checkOverpopulation() {
        List<String> overpopulations = new ArrayList<>();
        List<Dinosaur> dinos = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {

            String SQL = "SELECT breed, expected, actual" +
                    " FROM dinosaur" +
                    " GROUP BY breed";
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(SQL);
            while (results.next()) {
                String dino = results.getString("breed");
                Integer expected = results.getInt("expected");
                Integer actual = results.getInt("actual");
                if (actual > expected) {
                    overpopulations.add(new Dinosaur(dino, expected, actual).getName());
                }

            }


        } catch (SQLException e) {

            e.printStackTrace();
        }
        return overpopulations;
    }

}
/*
A checkOverpopulation metódus feladata, hogy térjen vissza azoknak a fajtáknak a nevével, amiknél a valós létszám magasabb, mint az elvárt (a fenti példában a Maiasaurus, a Velociraptor és a Hypsilophodontida), ABC szerint növekvő sorrendben.

Ha az adatbázis üres, akkor a metódus térjen vissza üres listával.

A megoldás során használj PreparedStatement-et!
 */
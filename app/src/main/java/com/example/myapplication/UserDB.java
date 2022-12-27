package com.example.myapplication;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDB {

    private static final int VERSION_BDD = 4;
    private static final String NOM_BDD = "Bis2.db";

    private static final String TABLE_USER = "table_user";
    private static final String COL_ID = "cin";
    private static final int NUM_COL_ID = 0;
    private static final String COL_First_Name = "Firstname";
    private static final int NUM_COL_First_Name = 1;
    private static final String COL_Last_Name = "Lastname";
    private static final int NUM_COL_Last_Name = 2;
    private static final String COL_username = "username";
    private static final int NUM_COL_Email = 3;
    private static final String COL_Password = "pwd";
    private static final int NUM_COL_Password = 4;

    private SQLiteDatabase bdd;

    private MaBaseSQLite maBaseSQLite;

    public UserDB(Context context) {
        //On créer la BDD et sa table
        maBaseSQLite = new MaBaseSQLite(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open() {
        //on ouvre la BDD en écriture
        bdd = maBaseSQLite.getWritableDatabase();
        //bdd = maBaseSQLite.getReadableDatabase();
    }

    public void close() {
        //on ferme l'accès à la BDD
        bdd.close();
    }

    public SQLiteDatabase getBDD() {
        return bdd;
    }

    public long insertUser(User user) {
        //Création d'un ContentValues
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COL_ID, user.getCin());
        values.put(COL_First_Name, user.getFirstname());
        values.put(COL_Last_Name, user.getLastname());
        values.put(COL_username, user.getUsername());
        values.put(COL_Password, user.getPwd());
        //on insère l'objet dans la BDD via le ContentValues
        long res = bdd.insert(TABLE_USER, null, values);
        return res;
    }


    public int getnbrUser(){
        Cursor c = bdd.rawQuery("select * from "+TABLE_USER, new String[] { });
        return c.getCount();
    }

    public User getUserWithusername(String username){
        //Récupère dans un Cursor les valeur correspondant à un etudiant contenu dans la BDD (ici on sélectionne le etudiant grâce à son prenom)
        Cursor z = bdd.rawQuery("select * from "+TABLE_USER+" where username='"+username+"'", new String[] { });
        return cursorToUser(z);
    }

    public int getUserWithcin(String usercin){
        //Récupère dans un Cursor les valeur correspondant à un etudiant contenu dans la BDD (ici on sélectionne le etudiant grâce à son prenom)
        Cursor z = bdd.rawQuery("select * from "+TABLE_USER+" where cin='"+usercin+"'", new String[] { });
        return z.getCount();
    }

    public int getUserWithlog(String username, String password){
        //Récupère dans un Cursor les valeur correspondant à un etudiant contenu dans la BDD (ici on sélectionne le etudiant grâce à son prenom)
        Cursor z = bdd.rawQuery("select * from "+TABLE_USER+" where username='"+username+"' and pwd='"+password+"'", new String[] { });
        return z.getCount();
    }

    private User cursorToUser(Cursor c){
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;
        c.moveToFirst();
        User user = new User();

        // séparation
        String firstname=c.getString(1);
        user.setFirstname(firstname);


        user.setFirstname(c.getString(NUM_COL_First_Name));
        user.setLastname(c.getString(NUM_COL_Last_Name));
        user.setUsername(c.getString(NUM_COL_Email));
        user.setPwd(c.getString(NUM_COL_Password));
        c.close();
        return user;
    }

}

package Exceptions;

/**
 *TODO:Erstellen Sie eine benutzerdefinierte Checked Exception namens InvalidUsernameException,
 *  die eine Fehlermeldung speichert. Implementieren Sie eine statische Methode
 *  registerUser(String username),
 *  die diese Exception wirft, sofern der Benutzername null ist oder weniger als 5 Zeichen besitzt;
 *  andernfalls soll eine Erfolgsmeldung auf der Konsole erscheinen.
 *
 */
public class InvalidUsernameException extends Exception{

    public InvalidUsernameException(String message){
        super(message);
    }

    public static void registerUser(String username) throws InvalidUsernameException {

        if(username == null|| username.length() < 5){
            throw new InvalidUsernameException("Username can not be null or have less than 5 characters");
        }else{
            System.out.println("User erfolgreich erstellt");
        }

    }

    public static void main(String[] args) throws InvalidUsernameException{
    registerUser("Anne");


    }



}

package fakeAPI;

public class InstaTesting {

    public static void main(String[] args) {
        Instagram instagram = new Instagram();

        // Sign up page
        // On sign up page users MUST provide name, age, username etc
        InstagramUser user1 = new InstagramUser("John Wick", 45, "jw2020");

        instagram.addUser(user1);
        System.out.println();

        String userToken = instagram.login("cbt1", "cbt2020");
        System.out.println(userToken);
        instagram.seeAllUsers(userToken);

//        InstagramUser user2 = new InstagramUser("James Bond", 41, "jbcool");
//        instagram.addUser(user2);
//        instagram.seeAllUsers("Cyb32134");

    }

}

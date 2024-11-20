/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalexamclaros;

/**
 *
 * @author Administrator
 */
public class NewClass {
    class friends {
        int userID;
        friends prev;
        friends next;
        
        public friends(int userID) {
            this.userID = userID;
            this.prev = null;
            this.next = null;
        }
    }
    private class bagongFriends {
        private friends head = null;
        private friends tail = null;
        
        public void addUser(int userID) {
            friends wenFriends = new friends(userID);
            if (head == null) {
                head = tail = wenFriends;
            }
            else {
                tail.next = wenFriends;
                wenFriends.prev = tail;
                tail = wenFriends;
            }
        }
    
    public boolean get(int userID) {
        friends current = head;
        while (current != null) {
            if (current.userID == userID) {
                return true;
            }
            current = current.next;
        }
        return false;
        }
    }
    
    private bagongFriends[] users;
    
    
    
    public NewClass(int numUsers) {
        users = new bagongFriends[numUsers];
        for (int i = 0; i < numUsers; i++) {
            users[i] = new bagongFriends();
        }
    }
    
    public void addFriendship(int userID1, int userID2) {
        users[userID1 - 1].addUser(userID2);
        users[userID2 - 1].addUser(userID1);
    }
    
    public bagongFriends getRecommendation(int userID) {
        bagongFriends recommend = new bagongFriends();
        bagongFriends DirectFriends = users[userID - 1];
        friends friends = DirectFriends.head;
        
        while (friends != null) {
            bagongFriends another = users[friends.userID - 1];
            friends otherfriends = another.head;
            
            while (otherfriends != null) {
                int mgaotherfriends = otherfriends.userID;
                if (mgaotherfriends != userID && !DirectFriends.get(userID) && !recommend.get(mgaotherfriends)) {
                    recommend.addUser(mgaotherfriends);
                }
                otherfriends = otherfriends.next;
            }
            friends = friends.next;
        }
        return recommend;
    }
    
    public void printRecommend(int userID) {
        bagongFriends recommend = getRecommendation(userID);
        System.out.println("Friend recommendations for " + userID + ": ");
        friends current = recommend.head;
        while (current != null) {
            System.out.println(current.userID + " ");
            current = current.next;
        }
        System.out.println();
    }
}


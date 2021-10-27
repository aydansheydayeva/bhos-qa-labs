/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bhos.qa.labs;

enum PermissionLevel {
  ADMIN,
  DEVELOPER,
  USER
}

public class PermissionManager {
    private PermissionLevel mCurrentLevel = PermissionLevel.USER;

    public String getPermissionLevel() {
        String to_Return = "";
        
        switch(mCurrentLevel) {
            case ADMIN:
                to_Return = "Admin";
                break;
            case DEVELOPER:
                to_Return = "Developer";
                break;
            case USER:
                to_Return = "User";
                break;
        }
        return to_Return;
    }

    public void setPermissionLevel(PermissionLevel permissionLvl) {
        mCurrentLevel = permissionLvl;
    }

    public static void main(String[] args) {
        PermissionManager permissionObj = new PermissionManager();
        permissionObj.setPermissionLevel(PermissionLevel.DEVELOPER);
        System.out.println(permissionObj.getPermissionLevel());
        permissionObj.setPermissionLevel(PermissionLevel.ADMIN);
        System.out.println(permissionObj.getPermissionLevel());
        permissionObj.setPermissionLevel(PermissionLevel.USER);
        System.out.println(permissionObj.getPermissionLevel());
    }
}

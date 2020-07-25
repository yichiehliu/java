package model;

import java.text.DateFormat;
import java.util.*;
import java.io.*;

public class UserService {
    public String USERS;
    public String absolutePath = "C:\\Users\\wii76\\Desktop\\eclipse-workspace\\B06703049-D\\";

    public UserService(String USERS) {
        this.USERS = USERS;
    }

    public boolean isUserExisted(String username) {
        return isInvalidUsername(username);
    }

    public boolean isInvalidUsername(String username) {
        File userhome = new File(absolutePath + "users\\");
        for (String file : userhome.list()) {
        	 if (file.equals(username)) {
        		 return true;
        	 }
         }
        // System.out.println(USERS);
//        System.out.println(username);
        return false;
    }

    public void createUserData(String email, String username, String password) throws IOException {

        File userhome = new File(absolutePath + "users\\" + username);
//        System.out.println(userhome);
        userhome.mkdir();
        FileWriter writer = new FileWriter(userhome + "\\profile");
        writer.write(email + "\t" + password);
        writer.close();
    }

    public boolean checkLogin(String username, String password) throws IOException {
        if (username != null && password != null) {
            File userhome = new File(absolutePath +"users\\");
            for (String file : userhome.list()) {
//                System.out.println(file);
                if (file.equals(username)) {
                    BufferedReader reader = new BufferedReader(new FileReader(userhome + "\\" + file + "\\profile"));
                    String passwd = reader.readLine().split("\t")[1];
                    if (passwd.equals(password)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private class TxtFilenameFilter implements FilenameFilter {
        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(".txt");
        }
    }

    private TxtFilenameFilter filenameFilter = new TxtFilenameFilter();

    private class DateComparator implements Comparator<Date> {
        @Override
        public int compare(Date d1, Date d2) {
            return -d1.compareTo(d2);
        }
    }

    private DateComparator comparator = new DateComparator();

    public List<UserModule> getUserModules(UserModule UserModule) throws IOException {
        File userhome = new File(absolutePath +"users\\");
        File border = new File(userhome + "\\" + UserModule.getUsername());
//        System.out.println("~~~"+border);
        String[] txts = border.list(filenameFilter);
        Map<Date, String> messages = new TreeMap<Date, String>(comparator);
//        System.out.println("123"+txts);
        for (String txt : txts) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(userhome + "\\" + UserModule.getUsername() + "\\" + txt), "UTF-8"));
            String text = null;
            StringBuilder builder = new StringBuilder();

            while ((text = reader.readLine()) != null) {
//            	System.out.println(text);
                builder.append(text);
            }
            Date date = new Date(Long.parseLong(txt.substring(0, txt.indexOf(".txt"))));
            messages.put(date, builder.toString());
//            titles.put(date, builder.toString());
            reader.close();
        }

        List<UserModule> UserModules = new ArrayList<UserModule>();

        for (Date date : messages.keySet()) {
            String txt = messages.get(date);
//            System.out.println("6786785"+ txt.split("\t")[1]);

            UserModules.add(new UserModule(UserModule.getUsername(), date, txt.split("\t")[0], txt.split("\t")[1]));
        }
        return UserModules;
    }

    public void addUserModule(UserModule UserModule) throws IOException {
        File userhome = new File(absolutePath +"users\\");
        String file = userhome + "/" + UserModule.getUsername() + "/" + UserModule.getDate().getTime() + ".txt";
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
        writer.write(UserModule.getTitle() + "\t" + UserModule.getTxt());
        writer.close();
    }

    public void deleteUserModule(UserModule UserModule) {
        File userhome = new File(absolutePath +"users\\");
        File file = new File(userhome + "/" + UserModule.getUsername() + "/" + UserModule.getDate().getTime() + ".txt");
        if (file.exists()) {
            file.delete();
        }
    }
}

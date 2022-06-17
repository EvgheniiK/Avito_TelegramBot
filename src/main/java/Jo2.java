import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class Jo2
{
    public static void main(String[] args)
    {
        Gson gson = new GsonBuilder().create();

        List<User> saveUsers = new ArrayList<>();

        for (int i = 0; i < 10; i++)
        {
            User user = new User();
            user.setName("Name " + i);
            user.setSurname("Surname " + i);
            user.setNickname("Nickname " + i);
            user.setPassword("password " + i);
            user.setGroup("User");
            saveUsers.add(user);
        }

        String jsonData = gson.toJson(saveUsers);
        //вывод сформированной json сроки для сохранения
        System.out.println(jsonData);

        User[] loadUsers = gson.fromJson(jsonData, User[].class);
        String mask = "User %s: Name: %s, Surname: %s, Nickname %s, Group: %s.";
        for (int i = 0; i < loadUsers.length; i++)
        {
            User user = loadUsers[i];
            System.out.println(String.format(mask, i, user.getName(),
                    user.getSurname(), user.getNickname(), user.getGroup()));
        }
    }

    static class User
    {
        private String name;
        private String surname;
        private String nickname;
        private String password;
        private String group;

        public void setName(String name)
        {
            this.name = name;
        }

        public String getName()
        {
            return name;
        }

        public void setSurname(String surname)
        {
            this.surname = surname;
        }

        public String getSurname()
        {
            return surname;
        }

        public void setNickname(String nickname)
        {
            this.nickname = nickname;
        }

        public String getNickname()
        {
            return nickname;
        }

        public void setPassword(String password)
        {
            this.password = password;
        }

        public String getPassword()
        {
            return password;
        }

        public void setGroup(String group)
        {
            this.group = group;
        }

        public String getGroup()
        {
            return group;
        }
    }
}
package ba.unsa.etf.rpr;


import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.User;
import org.apache.commons.cli.*;

import java.util.ArrayList;
import java.util.List;

public class AppCLI {
    public static void main(String[] args) throws Exception {
        Options options = new Options();
        options.addOption("h", "help", false, "Print this message");
        options.addOption("u", "username", true, "Username");
        options.addOption("p", "password", true, "Password");
        options.addOption("e", "email", true, "Email");
        options.addOption("b", "balance", true, "Balance");
        options.addOption("a", "add", false, "Add new user");
        options.addOption("d", "delete", false, "Delete user");
        options.addOption("l", "list", false, "List all users");
        options.addOption("c", "change", false, "Change password");
        options.addOption("s", "search", true, "Search user");
        options.addOption("v", "version", false, "Print version");
        CommandLineParser parser = new DefaultParser();
        CommandLine cl = parser.parse(options, args);
        if (cl.hasOption("h")) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("AppCLI", options);
        }
        if (cl.hasOption("s")) {
            User user = new User();
            user= DaoFactory.userDao().searchByEmail(cl.getOptionValue("e"));
            if (user != null) {
                System.out.println((user.getId()));
                System.out.println(user.getUsername());
                System.out.println(user.getEmail());
                System.out.println(user.getPassword());
            } else {
                System.out.println("User not found");
            }
        }
        if(cl.hasOption("l"))
        {
            List<User> users = new ArrayList<>();
            users=DaoFactory.userDao().getAll();
            for(User x: users)
            {
                System.out.println(x.toString());
            }
        }
        if(cl.hasOption("a"))
        {
            User user = new User();
            try
            {
                user.setUsername(cl.getOptionValue("u"));
                user.setPassword(cl.getOptionValue("p"));
                user.setEmail(cl.getOptionValue("e"));
                DaoFactory.userDao().add(user);
                System.out.println(user.toString());
            }
            catch (Exception e)
            {
                System.out.println("Error");
            }
        }
        if(cl.hasOption("d"))
        {
            User user = new User();
            user= DaoFactory.userDao().searchByEmail(cl.getOptionValue("e"));
            if(user != null)
            {
                DaoFactory.userDao().delete(user.getId());
                System.out.println("User deleted");
            }
            else
            {
                System.out.println("User not found");
            }
        }
        if(cl.hasOption("c"))
        {
            User user = new User();
            user= DaoFactory.userDao().searchByEmail(cl.getOptionValue("e"));
            if(user != null)
            {
                user.setPassword(cl.getOptionValue("p"));
                DaoFactory.userDao().update(user);
                System.out.println("Password changed");
            }
            else
            {
                System.out.println("User not found");
            }
        }
        if(cl.hasOption("v"))
        {
            System.out.println("Version 1.0");
        }

    }
}
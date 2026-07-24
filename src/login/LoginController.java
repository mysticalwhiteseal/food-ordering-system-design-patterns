package src.login;

import java.awt.event.*;

public class LoginController 
{
    private final LoginModel loginModel;
    private final LoginView loginView;
    private LoginObserver observer;
    
    public LoginController(LoginModel loginModel, LoginView loginView)
    {
        this.loginModel = loginModel;
        this.loginView = loginView;
        initListeners();
    }

    private void initListeners()
    {
        initLoginButtonListener();
    }

    private void initLoginButtonListener()
    {
        loginView.addLoginButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                String username = loginView.getUsername();
                String password = loginView.getPassword();

                boolean loginSuccessful = loginModel.authenticateLogin(username, password);
                if (loginSuccessful)
                {
                    notifyObserver();
                    loginView.dispose();
                }
                else
                {
                    loginView.displayErrorMessage("Invalid username or password!");
                }
            }
        });
    }

    public void addObserver(LoginObserver observer)
    {
        this.observer = observer;
    }

    private void notifyObserver()
    {
        observer.onLoginSuccess();
    }

}

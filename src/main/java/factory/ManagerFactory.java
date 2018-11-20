package factory;

import service.ClientManager;
import service.MentorManager;

public class ManagerFactory {

    public static ClientManager getClientManager() {    // TODO: Zouden eigenlijk interfaces als returntype moeten hebben
        return new ClientManager();
    }

    public static MentorManager getMentorManager() {
        return new MentorManager();
    }
}

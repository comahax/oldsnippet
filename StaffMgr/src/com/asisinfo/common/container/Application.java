package com.asisinfo.common.container;



/**
 * @author Quake Wang
 * @since 2004-7-13
 * @version $Revision$
 */
public class Application {
    private Container container;
    private static final Application instance = new Application();

    private Application() {

    }

    public static Application getInstance() {
        return instance;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }
}
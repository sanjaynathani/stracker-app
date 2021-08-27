package com.glassera.stracker.service;

import com.glassera.stracker.service.impl.StrackerServiceImpl;

public class ServiceLocator {

    private static StrackerService strackerService;

    public static StrackerService getStrackerService() {
        if ( strackerService == null ) {
            strackerService = new StrackerServiceImpl();
        }
        return strackerService;
    }
}

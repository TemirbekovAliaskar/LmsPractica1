package services;

import role.Admin;

public interface AdminService {
    Admin login(Admin admin);

    Admin addLogin(Admin admin);

    }

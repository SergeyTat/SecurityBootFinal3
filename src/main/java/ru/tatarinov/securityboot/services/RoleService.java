package ru.tatarinov.securityboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tatarinov.securityboot.model.Role;
import ru.tatarinov.securityboot.model.User;
import ru.tatarinov.securityboot.repositories.RoleRepsitory;

import java.util.List;
@Service
@Transactional
public class RoleService {
    private final RoleRepsitory roleRepsitory;

    @Autowired

    public RoleService(RoleRepsitory roleRepsitory) {
        this.roleRepsitory = roleRepsitory;
    }


    public List<Role> allRole() {
        return roleRepsitory.findAll();
    }

    public void addRole(Role role) {
        roleRepsitory.save(role);
    }
    @Transactional(readOnly = true)
    public Role findRole(Long id) {
        return roleRepsitory.findById(id).get();
    }
    @Transactional(readOnly = true)
    public void removeRole(Long id) {
        roleRepsitory.deleteById(id);
    }

}

package com.example.demo.securite.service.impl;

import com.example.demo.securite.bean.Permission;
import com.example.demo.securite.bean.Role;
import com.example.demo.securite.dao.RoleDao;
import com.example.demo.securite.service.facade.PermissionService;
import com.example.demo.securite.service.facade.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;
    private final PermissionService permissionService;
    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Role findByAuthority(String authority) {
        if (authority == null) return null;
        return roleDao.findByAuthority(authority);
    }

    @Override
    public Role findById(Long id) {
        if (id == null)
            return null;
        return roleDao.getOne(id);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        roleDao.deleteById(id);

    }

    @Override
    public Role save(Role role) {
        Role r =  findByAuthority(role.getAuthority());
        if(r != null) return r;
        List<Permission> perms = new ArrayList<>();
        role.getPermissions().forEach(perm -> {
            perms.add(permissionService.save(perm));
        });
        role.setPermissions(perms);
        return roleDao.save(role);
    }

    @Override
    public List<Role> create(List<Role> roles) {
        List<Role>  resultat = new ArrayList<>();
        roles.forEach(r->resultat.add(save(r)));
        return resultat;
    }

    @Override
    public Role update(Role role) {

        Role foundedRole = findById(role.getId());
        if (foundedRole == null) return null;
        return roleDao.save(role);
    }

    @Override
    @Transactional
    public int delete(Role role) {
        if (role.getAuthority() == null) return -1;

        Role foundedRole = findByAuthority(role.getAuthority());
        if (foundedRole == null) return -1;
        roleDao.delete(foundedRole);
        return 1;
    }

    @Override
    @Transactional
    public int deleteByAuthority(String authority) {

        return roleDao.deleteByAuthority(authority);
    }

    @Override
    public List<Role> findByUserName(String username) {
        if(username == null) return null;
        return roleDao.findAllByUsersUsername(username);
    }
}

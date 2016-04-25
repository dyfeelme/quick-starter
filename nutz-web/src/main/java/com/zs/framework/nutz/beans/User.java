package com.zs.framework.nutz.beans;

import java.util.List;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.ManyMany;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

@Table("t_user")
public class User extends BaseModel {
	
	public static final String STATUS_NORMAL = "00";
	public static final String STATUS_LOCKED = "01";
	public static final String STATUS_ACTIVE = "02";
	
	@Id
    protected int id;
    @Name
    @Column
    protected String name;
    @Column("passwd")
    @ColDefine(width=128)
    protected String password;
    @Column
    protected String salt;
    @Column
    private String status;
    @ManyMany(from="user_id", relation="t_user_role", target=Role.class, to="role_id")
    protected List<Role> roles;
    @ManyMany(from="user_id", relation="t_user_permission", target=Permission.class, to="permission_id")
    protected List<Permission> permissions;
    @One(target=UserProfile.class, field="id", key="userId")
    protected UserProfile profile;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	public UserProfile getProfile() {
		return profile;
	}
	public void setProfile(UserProfile profile) {
		this.profile = profile;
	}
}

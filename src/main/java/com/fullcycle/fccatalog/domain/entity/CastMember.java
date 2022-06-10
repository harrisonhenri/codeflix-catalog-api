package com.fullcycle.fccatalog.domain.entity;

import java.util.HashMap;
import java.util.UUID;

enum CastMemberType {
  TYPE1(1),
  TYPE2(2);

  private Integer type;
  private static final HashMap values = new HashMap();

  private CastMemberType(Integer type){
    this.type = type;
  }

  static {
    for (CastMemberType type: CastMemberType.values()) {
      values.put(type.type, type);
    }
  }

  public Integer getType() {
    return type;
  }

  public static Boolean valueOf(CastMemberType type) {
    CastMemberType castMemberType = (CastMemberType) values.get(type.type);
    return castMemberType != null;
  }
}


public class CastMember extends BaseEntity {
  private String name;
  private CastMemberType type;

  public CastMember(UUID id, String name, CastMemberType type) {
    super.setId(id);
    this.setName(name);
    this.setType(type);
  }
  public CastMember(String name, CastMemberType type) {
    super.generateUUID();
    this.setName(name);
    this.setType(type);
  }
  public CastMember(String name) {
    super.generateUUID();
    this.setName(name);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (name == null || name.length() == 0) throw new IllegalArgumentException("name is marked as non-null/non-empty but is null/empty");
    this.name = name;
  }

  public CastMemberType getType() {
    return type;
  }

  public void setType(CastMemberType type) {
    if (type == null) throw new IllegalArgumentException("type is marked as non-null and but is null");
    if (!CastMemberType.valueOf(type)) throw new IllegalArgumentException("type is marked as enum but is not");
    this.type = type;
  }    
}

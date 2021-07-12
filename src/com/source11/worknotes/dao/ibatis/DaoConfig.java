package com.source11.worknotes.dao.ibatis;

import com.ibatis.common.resources.Resources;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.DaoManagerBuilder;

import java.io.Reader;
import java.util.Properties;

public class DaoConfig {

  private static final String resource = "com/source11/worknotes/dao/ibatis/dao.xml";
  private static final DaoManager daoManager;

  static {
      daoManager = newDaoManager(null);
  }

  public static DaoManager getDaoManager() {
    return daoManager;
  }

  public static DaoManager newDaoManager(Properties props) {
    try {
      Reader reader = Resources.getResourceAsReader(resource);
      return DaoManagerBuilder.buildDaoManager(reader, props);
    } catch (Exception e) {
      throw new RuntimeException("Could not initialize DaoConfig.  Cause: " + e, e);
    }
  }

}

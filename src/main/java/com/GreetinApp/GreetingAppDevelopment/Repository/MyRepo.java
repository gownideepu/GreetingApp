package com.GreetinApp.GreetingAppDevelopment.Repository;

import com.GreetinApp.GreetingAppDevelopment.Model.MyModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepo extends JpaRepository<MyModel,Long>{

}

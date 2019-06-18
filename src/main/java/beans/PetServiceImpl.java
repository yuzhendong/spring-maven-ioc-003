package beans;

import org.springframework.stereotype.Service;

/*提交给spring管理形成bean*/
@Service
public class PetServiceImpl implements PetService{
public void saveObject(){
	System.out.println("saveObject");
}

public void updateObject() {
	// TODO Auto-generated method stub
	System.out.println("updateObject");
}
}

package beans;

import org.springframework.stereotype.Service;

/*�ύ��spring�����γ�bean*/
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

package RE56;
import RE56.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/***************
 
Author: DU Tianren 
FIN-Date:16/06/2020
Definition: Project Group A for RE56 17/06/2020
Description:
The program is to simulate the process of the OVSF code allocation, the spreading, the reception and the un-spreading. 
User.java is mainly to define and store each user's OVSF code, information. the calculate of spreading and unspreading. 
main.java is mainly to create the exact user and define them. Then show the process. 

**************/

public class main {

	public static void main(String[] args) {
		//define the number of users.
		Scanner num = new Scanner(System.in);
		System.out.println("select the max number of users: 1 or 2 or 4\n");
		int num_users = num.nextInt();
		
		//define the length of the information upload
		Scanner info_L = new Scanner(System.in);
		System.out.println("enter the length of the info\n");
		int L = info_L.nextInt();
		
		//************************************//
		//situation of 1 user
		if (num_users == 1) {			
			
			//user, information, ovsf creation and channelization
			User user1 = new User();
			ArrayList<Integer> ovsf1 = new ArrayList<Integer>();
			ovsf1 = OVSFallocation(num_users,1);
			user1.setOVSFcode(ovsf1);
			ArrayList<Integer> info1 = create_info(L,1);
			user1.setINFOuser(info1);
			user1.channelization();
			
			//show the data in each user
			user1.show_all_before(1);
			
			//carry out a combination signal according to each user
			ArrayList<Integer> combination = new ArrayList<Integer>();
			ArrayList<Integer> code0 = new ArrayList<Integer>();
			code0 = code0(user1.CHEDcode);
			combination = calculate_combination(user1.CHEDcode,code0,code0,code0);
			
			//Enter the combination signal and dechannelize it
			ArrayList<Integer> decombination = new ArrayList<Integer>();
			decombination = create_decombination();
			user1.dechannelization(decombination,1);
		}
		//************************************//
		//situation of 2 users
		else if (num_users == 2) {
			
			//user, information, ovsf creation and channelization
			User user1 = new User();
			ArrayList<Integer> ovsf1 = new ArrayList<Integer>();
			ovsf1 = OVSFallocation(num_users,1);
			user1.setOVSFcode(ovsf1);
			ArrayList<Integer> info1 = create_info(L,1);
			user1.setINFOuser(info1);
			user1.channelization();
			
			//user, information, ovsf creation and channelization
			User user2 = new User();
			ArrayList<Integer> ovsf2 = new ArrayList<Integer>();
			ovsf2 = OVSFallocation(num_users,2);
			user2.setOVSFcode(ovsf2);
			ArrayList<Integer> info2 = create_info(L,2);
			user2.setINFOuser(info2);
			user2.channelization();
			
			//show the data in each user
			user1.show_all_before(1);
			user2.show_all_before(2);
			
			//carry out a combination signal according to each user
			ArrayList<Integer> combination = new ArrayList<Integer>();
			ArrayList<Integer> code0 = new ArrayList<Integer>();
			code0 = code0(user1.CHEDcode);
			combination = calculate_combination(user1.CHEDcode,user2.CHEDcode,code0,code0);
			
			//Enter the combination signal and dechannelize it
			ArrayList<Integer> decombination = new ArrayList<Integer>();
			decombination = create_decombination();
			user1.dechannelization(decombination,1);
			user2.dechannelization(decombination,2);
		}
		//************************************//
		//situation of 4 users
		else {
			//user, information, ovsf creation and channelization
			User user1 = new User();
			ArrayList<Integer> ovsf1 = new ArrayList<Integer>();
			ovsf1 = OVSFallocation(num_users,1);
			user1.setOVSFcode(ovsf1);
			ArrayList<Integer> info1 = create_info(L,1);
			user1.setINFOuser(info1);
			user1.channelization();
			
			//user, information, ovsf creation and channelization
			User user2 = new User();
			ArrayList<Integer> ovsf2 = new ArrayList<Integer>();
			ovsf2 = OVSFallocation(num_users,2);
			user2.setOVSFcode(ovsf2);
			ArrayList<Integer> info2 = create_info(L,2);
			user2.setINFOuser(info2);
			user2.channelization();
			
			//user, information, ovsf creation and channelization
			User user3 = new User();
			ArrayList<Integer> ovsf3 = new ArrayList<Integer>();
			ovsf3 = OVSFallocation(num_users,3);
			user3.setOVSFcode(ovsf3);
			ArrayList<Integer> info3 = create_info(L,3);
			user3.setINFOuser(info3);
			user3.channelization();
			
			//user, information, ovsf creation and channelization
			User user4 = new User();
			ArrayList<Integer> ovsf4 = new ArrayList<Integer>();
			ovsf4 = OVSFallocation(num_users,4);
			user4.setOVSFcode(ovsf4);
			ArrayList<Integer> info4 = create_info(L,4);
			user4.setINFOuser(info4);
			user4.channelization();
			
			//show the data in each user
			user1.show_all_before(1);
			user2.show_all_before(2);
			user3.show_all_before(3);
			user4.show_all_before(4);
			
			//carry out a combination signal according to each user
			ArrayList<Integer> combination = new ArrayList<Integer>();
			combination = calculate_combination(user1.CHEDcode,user2.CHEDcode,user3.CHEDcode,user4.CHEDcode);
	
			//Enter the combination signal and dechannelize it
			ArrayList<Integer> decombination = new ArrayList<Integer>();
			decombination = create_decombination();
			user1.dechannelization(decombination,1);
			user2.dechannelization(decombination,2);
			user3.dechannelization(decombination,3);
			user4.dechannelization(decombination,4);
		}
	}


	//************************************//
	//function to create a combination for dechannelization
	public static ArrayList<Integer> create_decombination(){
		System.out.printf("enter the length of the signal\n");
		Scanner L = new Scanner(System.in);
		int length = L.nextInt();
		
		System.out.printf("enter the combination signal\n");
		Scanner x = new Scanner(System.in);
		ArrayList<Integer> decombination = new ArrayList<Integer>();
		for(int i=0;i<length;i++)
		{
			decombination.add(x.nextInt());
		}
		System.out.printf("The downlink combination signal is ");
		System.out.println(decombination);
		return decombination;
	}

	
	//funtion to create the information signal for each user
	public static ArrayList<Integer> create_info(int L, int index) {
		System.out.printf("enter the info for the %d th user, 4 numbers, 1 and 0\n",index);
		Scanner x = new Scanner(System.in);
		ArrayList<Integer> element_info = new ArrayList<Integer>();
		for(int i=0;i<L;i++)
			{
				element_info.add(x.nextInt());
	        }
		//System.out.printf("out");
		return element_info;	
	}
	
	
	//function to sum the signal and carry out a combination signal
	public static ArrayList<Integer> calculate_combination(ArrayList<Integer> code1,ArrayList<Integer> code2,ArrayList<Integer> code3,ArrayList<Integer> code4)
	{
		ArrayList<Integer> combination = new ArrayList<Integer>();
		for (int i = 0; i <code1.size();i++) {
			combination.add(code1.get(i) + code2.get(i) + code3.get(i) + code4.get(i));
		}
		System.out.printf("The uplink combination code is");
		System.out.println(combination);
		System.out.printf("\n");
		return combination;
	}
	
	//To fit the function of calculation
	public static ArrayList<Integer> code0(ArrayList<Integer> CHEDcode){
		ArrayList<Integer> code0 = new ArrayList<Integer>();
		for(int i = 0; i < CHEDcode.size();i++)
		{
			code0.add(0);
		}
		return code0;
	}
	
	//function to allocate the OVSF code
	public static ArrayList<Integer> OVSFallocation(int num_users,int index){
		ArrayList<Integer> ovsf = new ArrayList<Integer>();
		ovsf.add(1);
		while (num_users == 2)
		{
			if(index ==1) {ovsf.add(1);return ovsf;}
			else {ovsf.add(-1);return ovsf;}
		}
		while (num_users == 4)
		{
			if(index ==1) {ovsf.add(1);ovsf.add(1);ovsf.add(1);return ovsf;}
			else if (index ==2) {ovsf.add(1);ovsf.add(-1);ovsf.add(-1);return ovsf;}
			else if (index ==3) {ovsf.add(-1);ovsf.add(1);ovsf.add(-1);return ovsf;}
			else {ovsf.add(-1);ovsf.add(-1);ovsf.add(1);return ovsf;}
		}
		return ovsf;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}





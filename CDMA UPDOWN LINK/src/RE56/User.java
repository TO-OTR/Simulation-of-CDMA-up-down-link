package RE56;

import java.util.ArrayList;
import java.util.Arrays;

public class User{
	//basic data
	ArrayList<Integer> OVSFcode 	= 	new ArrayList<Integer>();
	ArrayList<Integer> INFOuser 	= 	new ArrayList<Integer>();
	ArrayList<Integer> CHEDcode 	= 	new ArrayList<Integer>();
	ArrayList<Integer> UNCHEDcode 	= 	new ArrayList<Integer>();
	
	//set ovsf
	public void setOVSFcode(ArrayList<Integer> ovsf){
		for(int i = 0; i < ovsf.size(); i++) {
			OVSFcode.add(ovsf.get(i));
		}
		//System.out.println(Arrays.toString(OVSFcode));
	}
	
	//get ovsf
	public ArrayList<Integer> getOVSFcode() {
		return this.OVSFcode;
	}

	//set information signal
	public void setINFOuser(ArrayList<Integer> info) {
		for(int i = 0;i<info.size();i++) {
			INFOuser.add(info.get(i));
		}
		//System.out.println(Arrays.toString(INFOuser));
	}
	
	//channelize with the information and the ovsf code
	public void channelization(){
		int n = 0;
		for(int i = 0; i<(INFOuser.size() * OVSFcode.size());i = i + OVSFcode.size()) {
			if(INFOuser.get(n) == 1){
				for (int j = 0; j < OVSFcode.size(); j++)
					CHEDcode.add(OVSFcode.get(j));
			}
			else
				for (int j = 0; j < OVSFcode.size(); j++)
					CHEDcode.add(-1 * OVSFcode.get(j));
			n++;
		}
	}
	
	public ArrayList<Integer> get_channelization_code() {
		return this.CHEDcode;
	}

	public void dechannelization(ArrayList<Integer> decombination,int index){
		int n = 0;
		for(int i = 0; i<(decombination.size());i = i + OVSFcode.size()) {
			int sum = 0;
			for(int j = 0;j <OVSFcode.size();j++)
				sum = sum + decombination.get(i+j) * OVSFcode.get(j);
			if (sum > 0)
				UNCHEDcode.add(1);
			else
				UNCHEDcode.add(0);
			n++;
		}
		//test if all signal is 0
		int flag = 0;
		for (int k = 0;k<UNCHEDcode.size();k++)
			if(UNCHEDcode.get(k)==0)
				flag++;
		
		if (flag==UNCHEDcode.size())
		{
			System.out.printf("There is no information for user%d. ", index);
			System.out.println(UNCHEDcode);
		}
		else 
		{
			System.out.printf("The information of user%d is ", index);
			System.out.println(UNCHEDcode);
		}
		
	}

	public void show_all_before(int index)
	{
		System.out.printf("The spreading data for %d th user is \n",index);
		System.out.printf("The ovsf code is");
		System.out.println(OVSFcode);
		System.out.printf("The information is");
		System.out.println(INFOuser);
		System.out.printf("The channelized code is");
		System.out.println(CHEDcode);
		System.out.printf("\n");
	}


}

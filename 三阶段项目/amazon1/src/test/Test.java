package test;

import java.util.List;

import com.hwua.bean.HwuaOrder;
import com.hwua.bean.HwuaOrderDetail;
import com.hwua.biz.IHwuaOrderBiz;
import com.hwua.biz.impl.OrderBizImpl;

public class Test {

	public static void main(String[] args) {
		//IHwuaUserDao iud=new IHwuaUserDaoImpl();
		//IHwuaProductCategoryDao a=new IHwuaProductCategoryDaoImpl();
		//HwuaUser user=iud.findUserByName("admin");
		// user=iud.findUserByName("wuhai");
		IHwuaOrderBiz ihob=new OrderBizImpl();
		List<HwuaOrder> list=ihob.searchAllOrder(1011L);
		System.out.println(list.size());
		for(HwuaOrder o:list){
		for(HwuaOrderDetail d:o.getDetails()){
			System.out.println(d.getHod_id());
		}
		}
	}

}

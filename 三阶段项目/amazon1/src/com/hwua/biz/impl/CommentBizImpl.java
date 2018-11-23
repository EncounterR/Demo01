package com.hwua.biz.impl;

import java.util.List;

import com.hwua.bean.HwuaComment;
import com.hwua.biz.IHwuaCommentBiz;
import com.hwua.dao.ICommentDao;
import com.hwua.dao.impl.CommentDaoImpl;

public class CommentBizImpl implements IHwuaCommentBiz{
	
	ICommentDao icd=new CommentDaoImpl();
	@Override
	public int addComment(HwuaComment comment) {
		
		return icd.addComment(comment);
	}

	@Override
	public List<HwuaComment> allComments() {
		
		return icd.allComments();
	}

	@Override
	public List<HwuaComment> getallCommentsByUserId(String nickName) {
		return icd.getallCommentsByUserId(nickName);
	}

	@Override
	public List<HwuaComment> getAllCommentsByProdctId(long id) {
		// TODO Auto-generated method stub
		return icd.getAllCommentsByProdctId(id);
	}

}

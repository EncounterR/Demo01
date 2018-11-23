package com.hwua.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.hwua.bean.HwuaComment;
import com.hwua.dao.ICommentDao;
import com.hwua.util.JDBCTemplate;

public class CommentDaoImpl extends JDBCTemplate implements ICommentDao {

	@Override
	public int addComment(HwuaComment comment) {
		String sql = "INSERT INTO HWUA_COMMENT(HC_ID,HC_CONTENT,HC_CREATE_TIME,HC_NICK_NAME,HP_ID) VALUES(SEQ_COMMENT.NEXTVAL,?,?,?,?)";
		int row = update(sql, pstmt -> {
			pstmt.setString(1, comment.getHc_content());
			pstmt.setDate(2, new java.sql.Date(comment.getHc_create_time().getTime()));
			pstmt.setString(3, comment.getHc_nick_name());
			pstmt.setLong(4, comment.getHp_id());
		});
		return row;
	}

	@Override
	public List<HwuaComment> allComments() {
		List<HwuaComment> list = new ArrayList<HwuaComment>();
		String sql = "select * from HWUA_COMMENT";
		query(sql, null, rs -> {
			while (rs.next()) {
				HwuaComment comment = new HwuaComment();
				comment.setHc_id(rs.getLong("HC_ID"));
				comment.setHc_reply(rs.getString("HC_REPLY"));
				comment.setHc_content(rs.getString("HC_CONTENT"));
				comment.setHc_create_time(rs.getDate("HC_CREATE_TIME"));
				comment.setHc_reply_time(rs.getDate("HC_REPLY_TIME"));
				comment.setHc_state(rs.getInt("HC_STATE"));
				comment.setHc_nick_name(rs.getString("HC_NICK_NAME"));
				comment.setHp_id(rs.getLong("HP_ID"));
				list.add(comment);
			}
		});
		return list;
	}

	@Override
	public List<HwuaComment> getallCommentsByUserId(String nickName) {
		List<HwuaComment> list = new ArrayList<HwuaComment>();
		String sql = "select * from HWUA_COMMENT where HC_NICK_NAME=?";
		query(sql, pstmt -> {
			pstmt.setString(1, nickName);
		}, rs -> {
			while (rs.next()) {
				HwuaComment comment = new HwuaComment();
				comment.setHc_id(rs.getLong("HC_ID"));
				comment.setHc_reply(rs.getString("HC_REPLY"));
				comment.setHc_content(rs.getString("HC_CONTENT"));
				comment.setHc_create_time(rs.getDate("HC_CREATE_TIME"));
				comment.setHc_reply_time(rs.getDate("HC_REPLY_TIME"));
				comment.setHc_state(rs.getInt("HC_STATE"));
				comment.setHc_nick_name(rs.getString("HC_NICK_NAME"));
				comment.setHp_id(rs.getLong("HP_ID"));
				list.add(comment);
			}
		});
		return list;
	}

	@Override
	public List<HwuaComment> getAllCommentsByProdctId(long id) {
		List<HwuaComment> list = new ArrayList<HwuaComment>();
		String sql = "select * from HWUA_COMMENT where hp_id=?";
		query(sql, pstmt -> {
			pstmt.setLong(1, id);
		}, rs -> {
			while (rs.next()) {
				HwuaComment comment = new HwuaComment();
				comment.setHc_id(rs.getLong("HC_ID"));
				comment.setHc_reply(rs.getString("HC_REPLY"));
				comment.setHc_content(rs.getString("HC_CONTENT"));
				comment.setHc_create_time(rs.getDate("HC_CREATE_TIME"));
				comment.setHc_reply_time(rs.getDate("HC_REPLY_TIME"));
				comment.setHc_state(rs.getInt("HC_STATE"));
				comment.setHc_nick_name(rs.getString("HC_NICK_NAME"));
				comment.setHp_id(rs.getLong("HP_ID"));
				list.add(comment);
			}
		});
		return list;
	}

}

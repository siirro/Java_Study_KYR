package com.iu.start.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {
	
	@Autowired
	NoticeDAO noticeDAO;
	
	public List<NoticeDTO> getlist(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.getlist();
	}


}

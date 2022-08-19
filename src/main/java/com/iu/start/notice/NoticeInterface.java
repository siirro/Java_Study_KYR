package com.iu.start.notice;

import java.util.List;

public interface NoticeInterface {
	
	public List<NoticeDTO> getlist()throws Exception;

	public NoticeDTO getDetail(NoticeDTO noticeDTO)throws Exception;

	public int add(NoticeDTO noticeDTO)throws Exception;

	public int delete(NoticeDTO noticeDTO)throws Exception;

	public int update(NoticeDTO noticeDTO)throws Exception;

}

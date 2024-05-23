package com.busanit501.samplejsp501.lunchmember.service;

import com.busanit501.samplejsp501.lunchmember.dao.LunchMemberDAO;
import com.busanit501.samplejsp501.lunchmember.domain.LunchMemberVO;
import com.busanit501.samplejsp501.lunchmember.dto.LunchMemberDTO;
import com.busanit501.samplejsp501.todo.dao.MemberDAO;
import com.busanit501.samplejsp501.todo.domain.MemberVO;
import com.busanit501.samplejsp501.todo.dto.MemberDTO;
import com.busanit501.samplejsp501.todo.util.MapperUtil;
import org.modelmapper.ModelMapper;

public enum LunchMemberService {
  INSTANCE;

  private LunchMemberDAO lunchmemberDAO;
  private ModelMapper modelMapper;

  LunchMemberService() {
    lunchmemberDAO = new LunchMemberDAO();
    modelMapper = MapperUtil.INSTANCE.get();
  }

  // 하나 조회
  public LunchMemberDTO getOneMember(String mid, String mpw) throws Exception {
    LunchMemberVO sample = lunchmemberDAO.getWithPasswordMember(mid, mpw);
//    log.info("TodoService , 확인1, sample : " + sample);
    LunchMemberDTO lunchmemberDTO = modelMapper.map(sample, LunchMemberDTO.class);
    return lunchmemberDTO;
  }
  // 회원가입
  public void insertMember(LunchMemberDTO lunchmemberDTO) throws Exception {
    LunchMemberVO lunchmemberVO = modelMapper.map(lunchmemberDTO, LunchMemberVO.class);
    lunchmemberDAO.insertMember(lunchmemberVO);
  }

  public void updateUUID(String mid, String uuid) throws Exception {
    lunchmemberDAO.updateUUID(mid, uuid);
  }

  public LunchMemberDTO selectUUID(String uuid) throws Exception {
    LunchMemberVO lunchmemberVO = lunchmemberDAO.selectUUID(uuid);
    LunchMemberDTO lunchmemberDTO = modelMapper.map(lunchmemberVO, LunchMemberDTO.class);
    return lunchmemberDTO;

  }

}

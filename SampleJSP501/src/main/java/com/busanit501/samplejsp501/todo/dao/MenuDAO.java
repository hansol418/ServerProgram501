package com.busanit501.samplejsp501.todo.dao;

import com.busanit501.samplejsp501.todo.domain.MenuVO;
import com.busanit501.samplejsp501.todo.domain.TodoVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO {
    // 기능 구현만 만들고, 단위 테스트 진행중이고, 나중에 화면 붙여서 작업 할 예정.
    // 조회 select
    // 데이터베이스 직접적인 데이터 연동할 때 사용하는 모델 클래스 :VO
    public List<MenuVO> selectAll() throws Exception{
        // 예외 처리 여부를 , throws 진행하기.
        // 디비 연결 하는 순서
        // 1) 연결 하는 도구 Connection 타입의 인스턴스 필요
        // 2) SQL 전달하는 도구 : PreparedStatement 타입의 인스턴스 필요
        // 3) select 할 때는, 조회 결과를 받기 위한 ResultSet 타입의 인스턴스 필요
        // 작업 후, 반납. -> @Cleanup 사용할 예정.
        String sql = "select * from lunchmenu";
        //1)
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet resultSet = pstmt.executeQuery();
        // 디비에서 조회한 데이터 내용들을 담을 임시 List 가 필요함. 여기에 담을 예정.
        List<MenuVO> samples = new ArrayList<MenuVO>();

        while (resultSet.next()){
            // 기존에는 , set 를 이용해서 담는 방법
            // 임시 TodoVO에 담기, -> 다시 임시 목록에 담기.
            // 방법1
//            MenuVO MenuVO = new MenuVO();
            // resultSet.getLong("tno"), 디비에서 조회한 내용.
//            MenuVO.setTno(resultSet.getLong("tno"));
//            MenuVO.setTitle(resultSet.getString("title"));
//            MenuVO.setDueDate(resultSet.getDate("dueDate").toLocalDate());
//            MenuVO.setFinished(resultSet.getBoolean("finished"));
            // 리스트에 담기.
//            samples.add(MenuVO);
            // builder 패턴으로 담는 방법.
            // 방법2
            MenuVO MenuVOBuilder = MenuVO.builder()
                    .tno(resultSet.getLong("tno"))
                    .title(resultSet.getString("title"))
                    .dueDate(resultSet.getDate("dueDate").toLocalDate())
                    .finished(resultSet.getBoolean("finished"))
                    .build();
            // 리스트에 담기.
            samples.add(MenuVOBuilder);
        }

        //임시 반환값.
        return samples;
    }

    // 쓰기 insert

    // 수정 update

    // 삭제 delete
}

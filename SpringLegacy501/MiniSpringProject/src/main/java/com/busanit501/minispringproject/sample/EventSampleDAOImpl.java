package com.busanit501.minispringproject.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("event")
public class EventSampleDAOImpl implements SampleDAO{
}








import React, { useEffect, useState } from 'react'
import { DateRange } from 'react-date-range'
import { addDays } from 'date-fns';
import style from './calendarBook.module.css'
export const CalendarBook = ({datesCalendar, dateRange, bookRangeDates}) => {

    console.log(bookRangeDates);
    const[mobile, setMobile] = useState();    
    const [width, setWidth] = useState(window.innerWidth)
    
    const days = bookRangeDates.map(day =>{ 
        const date = new Date (day.fechaNoDisponible)
        const numberOfMlSeconds = date.getTime();
        const addMlSeconds = 180 * 60000;
       return  new Date(numberOfMlSeconds + addMlSeconds);
    });
    
    // var currentDateObj = new Date();
    // var numberOfMlSeconds = currentDateObj.getTime();
    // var addMlSeconds = 60 * 60000;
    // var newDateObj = new Date(numberOfMlSeconds + addMlSeconds);
    

    const updateWindowDimensions = () => {
        const newWidth = window.innerWidth;
        setWidth(newWidth);
    };

    useEffect(() => {
        window.addEventListener('onclick', updateWindowDimensions);
        width>460? setMobile(false): setMobile(true)
       
    }, [width]);
    
    window.addEventListener("resize", function() {
        if (window.matchMedia("(min-width:460px)").matches) {
            setMobile(false)
        } else {
            setMobile(true)
        }
    })

  return (
    <div>
        <DateRange
          editableDateInputs={true}
          onChange={item => datesCalendar(item)}
          moveRangeOnFirstSelection={false}
          ranges={dateRange}
          months={mobile? 1:2}
          direction={'horizontal'}
          minDate={addDays(new Date(), 0)}
          retainEndDateOnFirstSelection= {true}
          disabledDates={days}
         
          
        />
    </div>
  )
}

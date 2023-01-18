import React from 'react'
import { useEffect } from 'react';
import { useState } from 'react';
import style from './imageSlider.module.css'

const ImageSliderMobile = ({images}) => {
    const [currentIndex, setCurrentIndex] = useState(0)
    const [width, setWidth] = useState(window.innerWidth)
    const[mobile, setMobile] = useState(true);

    let pictures = images

  
    const updateWindowDimensions = () => {
      const newWidth = window.innerWidth;
      setWidth(newWidth);
  };

    useEffect(() => {
      window.addEventListener('onclick', updateWindowDimensions);
      width>821? setMobile(false): setMobile(true)
     
  }, [width]);

  window.addEventListener("resize", function() {
    if (window.matchMedia("(min-width:821px)").matches) {
        setMobile(false)
    } else {
        setMobile(true)
    }
})
    
    useEffect(() => {
      while(mobile){
      const interval = setInterval(() => {
        let newIndex = currentIndex + 1;
        if(newIndex < pictures.length){
          setCurrentIndex(newIndex)
        }else{
          setCurrentIndex(0)
        }
      }, 3000);
      return () => clearInterval(interval);
      }
    }, [currentIndex]);

    const handleClickNext = ()=>{
      let newIndex = currentIndex + 1;
     
      if(newIndex < pictures.length){
        setCurrentIndex(newIndex)
       
      }
    }

    const handleClickPrev = ()=>{
      let newIndex = currentIndex-1;
      if(newIndex >= 0){
        setCurrentIndex(newIndex)
     
      }
    }

    const goToSlide = (slideIndex) =>{
      setCurrentIndex(slideIndex)
    }

  return (
    <>{images&&

        <div className={style.container}>
            <div className={style.leftArrow}onClick={handleClickPrev}> ❰ </div>
            <div className={style.rightArrow} onClick={handleClickNext}> ❱ </div>
            <span className={style.pages}>{`${currentIndex+1}/${pictures.length}`}</span>
          <div className={style.imagesContainer}> 

            <div
              className={style.imagesStyle}
              style={{ backgroundImage: `url(${pictures[currentIndex].url})`}}>
            </div>
              <div className={style.bottomImages}>
                  {pictures.map((item, i) =>(                
                    <div className={style.bottomImage} key={i}  onClick={()=>goToSlide(i)} style={{ backgroundImage: `url(${item.url})` }}></div>
                    ))}
             </div> 
         </div>
        
      </div>
    }
    </>
  )
}

export default ImageSliderMobile
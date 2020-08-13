import React from '../../../../node_modules/react';
import BgImg from '../../../assets/pictures/brokenpage.jpeg';

var BgImgStyle = {
    backgroundImage: `url(${BgImg})`,
    backgroundPosition: 'center',
  backgroundSize: 'cover',
  backgroundRepeat: 'no-repeat',
  height: '500px'
};

function Error404() {
  return (
      <div className="Error404BgImg">
            
                 ERROR
            
      </div>
  );
}

export default Error404;

import React, { useState, useEffect } from 'react';
import TableUsers from '../../helpers/table';
import RequestUser from '../../../services/backend/userRequests';
    


        function Asset() {

            
    
        return (

            
            <div className="container">
                <TableUsers/>
                
                {/*<button onClick={RequestUser.deleteUserById()} className="btn btn-danger">DANGER, RIP ERLINGOS</button>*/}
            </div>
        )

}
    


export default Asset;


import React from 'react';
import {Link} from 'react-router-dom'



function Header() {
  return (
    <div className="Header">
        <header>
            <div className="logo">
            <b>Thurtimous</b>
            </div>

            <nav>
                <ul>
                    <li className="first">
                    <Link to="/">Home</Link>
                    </li>
                    <li>
                       <Link to="/asset">Assets</Link>
                    </li>
                    <li>
                    <Link to="/contact">Contact</Link>
                    </li>
                    <li className="last">
                    <Link to="/about">About</Link>
                    </li>
                </ul>
            </nav>
        </header>
        
    </div>
  );
}

export default Header;

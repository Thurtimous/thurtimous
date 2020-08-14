import React, { useState, useEffect } from 'react';
import ReactDataGrid from 'react-data-grid';
import 'react-data-grid/dist/react-data-grid.css';
import RequestUser from '../../services/backend/userRequests';
import { AutoSizer } from 'react-virtualized';

const Table = () => {

    const [users, setUsers] = useState([]);
    function getUsers() {
        RequestUser.getAllUsers().then((response) => {
            console.log(response['data']);
            console.log(response);
            setUsers(response['data']);
        })
    }
    useEffect(() => {
        if (users.length === 0) {
            getUsers()
        }
    });

    // function kappa(id) {
    //     RequestUser.deleteUserById(id).then(() => {
    //         getUsers();
    //     });
    // }

    const columns = [
        { key: "id", name: "ID", editable: false },
        { key: "firstName", name: "Firstname", editable: true },
        { key: "middleName", name: "Middlename", editable: true },
        { key: "lastName", name: "Lastname", editable: true }
    ];

    const rows = [users];

    return (
        <div id="superTable">
            <AutoSizer>
        {({ height, width }) => (
        <ReactDataGrid
          rowKey="id"
          columns={columns}
          rows={users}
          height={height}
          width={width}
          defaultColumnOptions={{
            sortable: true,
            resizable: true
          }}
        />
        )}
        </AutoSizer>
        </div>
    );
    
}

export default Table;
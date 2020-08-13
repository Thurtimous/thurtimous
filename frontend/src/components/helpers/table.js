import React, { useState, useEffect } from 'react';
import Editable from 'react-x-editable';
import RequestUser from '../../services/backend/userRequests';
const Table = ({ }) => {

    const [users, setUsers] = useState([]);

    function getUsers() {
        RequestUser.getAllUsers().then((response) => {
            console.log(response['data']);
            console.log(response);
            setUsers(response['data']);
        })
    }

    function kappa(id) {
        RequestUser.deleteUserById(id).then(() => {
            getUsers();
        });


    }

    useEffect(() => { getUsers(); }, []);
    return (
        <table className="table table-dark userTable">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>firstName</th>
                    <th>Middlename</th>
                    <th>Lastname</th>
                    <th>Delete my shit</th>
                </tr>
            </thead>
            <tbody>
                {(users.length > 0) ? users.map((user, index) => {
                    return (
                        <tr key={index}>
                            <td>
                                <Editable
                                    value={user.id}
                                    name="id"
                                    dataType="text"
                                    showButtons={false}
                                    validate={(value) => {
                                        if (!value) {
                                            return 'Required';
                                        }
                                    }}
                                />
                            </td>
                            <td>
                                <Editable
                                    value={user.firstName}
                                    name="firstname"
                                    dataType="text"
                                    showButtons={false}
                                    validate={(value) => {
                                        if (!value) {
                                            return 'Required';
                                        }
                                    }}
                                />
                            </td>
                            <td>
                                <Editable
                                    value={user.middleName}
                                    name="middlename"
                                    dataType="text"
                                    showButtons={false}

                                />
                            </td>
                            <td>
                                <Editable
                                    value={user.lastName}
                                    name="lastname"
                                    dataType="text"
                                    showButtons={false}
                                    validate={(value) => {
                                        if (!value) {
                                            return 'Required';
                                        }
                                    }}
                                />
                            </td>
                            <td>
                                <button type="submit" onClick={() => { kappa(user.id) }} className="btn btn-danger">DANGER, RIP ERLINGOS</button>
                            </td>
                        </tr>
                    )
                }) : <tr><td colSpan="5">Characters will show up here WOHO</td></tr>}
            </tbody>
        </table>

    );
    
}
export default Table;
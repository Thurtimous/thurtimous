import axios from 'axios';
const BACKEND_API_URL = 'http://infamous.no:1337'

class UserRequests{
    getAllUsers() {
        return axios.get(BACKEND_API_URL + `/user/all`);
    }
    deleteUserById(id){
        return axios.delete(BACKEND_API_URL + "/user/delete/" + id);
    }
}
export default new UserRequests()
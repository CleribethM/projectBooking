const authHeader = () => {
    const user = JSON.parse(localStorage.getItem("user"));

    if (user && user.accessToken) {
      return { Authorization: 'Bearer ' + user.accessToken };
      // return { "x-auth-token": user.accessToken };
    } else {
      return {};
    }
}

export default authHeader
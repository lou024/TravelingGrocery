import React from 'react'
import { useEffect, useState} from 'react'

import { useGoogleLogin } from 'react-google-login'
import { GoogleLogin} from 'react-google-login'

import { useHistory } from 'react-router-dom'
import { useDispatch } from 'react-redux'
import Button from '@material-ui/core/Button'
//Local components
import { send_Google_User_info } from '../../actions/actions'

const Login = ({client_id}) => {
    const dispatch = useDispatch()
    const history = useHistory()
    const [test, setTest] = useState("Empty")
    //when Login works
    const onSuccess = (response) => {
        console.log(`Login Success: currentUser ${response.profileObj}`)
        //console.log('Loaded: ' + loaded)
        dispatch(send_Google_User_info(response))
        setTest(response.profileObj.name)
        history.push('/home')
    }
    //When login is a failute
    const onFailure = (response) => {
        console.log('Error: ' + response)
    }

    const { signIn, loaded } = useGoogleLogin({
        onSuccess: onSuccess,
        clientId: client_id,
        isSignedIn: true,
        onFailure: onFailure,
    })
    //=================================

    useEffect(()=>{
        console.log('From login')
    },[])

    return (
        <div>
            <GoogleLogin
                clientId={client_id}
                buttonText="Login"
                onSuccess={onSuccess}
                onFailure={onFailure}
                cookiePolicy={'single_host_origin'}
                isSignedIn={true}
            />
            {/* <Button onClick={signIn} className='login_button'>
                Login
            </Button>
         */}
         <p>THIS IS A TEST: {test}</p>
        </div>
    )
}

export default Login

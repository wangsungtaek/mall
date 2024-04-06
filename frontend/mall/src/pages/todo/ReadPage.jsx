import React from 'react';
import {useParams, useNavigate, useSearchParams, createSearchParams} from 'react-router-dom';

function ReadPage(props) {

  const {tno} = useParams()
  const nativate = useNavigate();
  
  const [queryParams] = useSearchParams();
  const page = queryParams.get("page") ? parseInt(queryParams.get("page")) : 1;
  const size = queryParams.get("size") ? parseInt(queryParams.get("size")) : 10;
  const queryStr = createSearchParams({page,size}).toString();
  
  const moveToModify = () => {

    nativate({
      pathname: `/todo/modify/${tno}`,
      search: queryStr
    })
  }

  const moveToList = () => {

    nativate({
      pathname: `/todo/list`,
      search: queryStr
    })
  }

  return (
    <div className='p-4 w-full bg-white'>
      <div className='text-3xl font-extrabold'>
        ReadPage
      </div>

      <button onClick={moveToModify}>To Modify</button>
      <button onClick={moveToList}>To List</button>
    </div>
  );
}

export default ReadPage;
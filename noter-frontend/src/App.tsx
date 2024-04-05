import {RouterProvider} from "react-router-dom";
import {router} from "./router/Router.tsx";

export const App = () => {
  return (
      <RouterProvider router={router}/>
  );
}
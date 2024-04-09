import {SubmitHandler, useForm} from "react-hook-form";
import {useNavigate} from "react-router-dom";

export const IndexPage = () => {
  const navigate = useNavigate();
  const {register, handleSubmit} = useForm<{ documentId: string }>();

  const sendDocument: SubmitHandler<{ documentId: string }> = async (data) => {
    navigate(`/${data.documentId}`);
  }

  return (
      <div className="hero min-h-screen bg-base-200">
        <div className="hero-content text-center">
          <div className="max-w-md">
            <h1 className="text-5xl font-bold">Noter</h1>
            <p className="py-6">Choose a name and start noting!</p>
            <form onSubmit={handleSubmit(sendDocument)}>
              <div className={"join"}>
                <input type="text" className="input input-bordered join-item"
                       placeholder={"Type a name..."} {...register("documentId")}/>
                <button className="btn btn-neutral join-item">Start note!</button>
              </div>
            </form>
          </div>
        </div>
      </div>
  );
}
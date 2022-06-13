.PHONY: all
all: Dockerfile
	docker build -t ubuntu-ant-maven -f Dockerfile .

.PHONY: clean
clean:
	-docker rmi ubuntu-ant-maven

.PHONY: run
run:
	docker run --rm -it  -v "$(shell pwd):/data" -w "/data"  -u "$(shell id -u):$(shell id -g)"  --entrypoint "bash"  ubuntu-ant-maven

.PHONY: run_as_root
run_as_root:
	docker run --rm -it  -v "$(shell pwd):/data" -w "/data"  --entrypoint "bash"  ubuntu-ant-maven

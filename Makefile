#################################################################################
# Makefile for building the lecture material (website and slides)
#################################################################################

## Run 'make' or 'make help' to display commonly used targets. "make slides" and
## "make web" should be the most useful targets (also, targets for individual
## files also exist but should only be used if you know what you are doing).
##
## (a) You can use the toolchain installed in the Docker image "pandoc-lecture",
##     which comes ready to use (no other dependencies).
## (b) Alternatively, you need to
##         (1) install all tools (Pandoc, Hugo, TexLive) manually to your
##             operating system, and
##         (2) clone the pandoc-lecture repo plus relearn theme locally to a
##             specific location (${HOME}/.local/share/pandoc/):
##             "git clone --depth 1 https://github.com/cagix/pandoc-lecture.git ${HOME}/.local/share/pandoc/"
##             "wget https://github.com/McShelby/hugo-theme-relearn/archive/refs/tags/${RELEARN}.tar.gz"
##             "tar -zxf ${RELEARN}.tar.gz --strip-components 1 -C ${HOME}/.local/share/pandoc/hugo/hugo-theme-relearn/"
##             (Alternatively, just use "make install_scripts_locally" using https://github.com/cagix/pandoc-lecture/)
##
## To build the mentioned Docker image or for the required packages for a native
## installation, see https://github.com/cagix/pandoc-lecture/docker.
##
## If you want to use the Docker image to build the lecture material, start the
## container interactively using "make runlocal" and run the desired Make targets
## in the interactive container shell.

## NOTE:
## The pdf slides that can be generated for certain chapters are named by taking
## the relative path of the respective source file and replacing any '/' with an
## '_' (e.g. A/B/C -> A_B_C).
## This must be reversable in order to find the prerequisites for each output
## file. Therefore, any subdirectory of the $(SRC_DIR) directory must NOT contain
## any '_'.

#--------------------------------------------------------------------------------
# Literature and other sources: Please adjust to your course!
#--------------------------------------------------------------------------------

## Readings data template
READINGS = data/readings.yaml
BIBTEX   = pm.bib

#--------------------------------------------------------------------------------
# Tools
#--------------------------------------------------------------------------------
## Define tools to process various types of source files.
##
## Note: LaTeX needs to be called in the folder of the .tex file to be processed.
## In the rule that generates images from tex files, the variable "$<" is set to
## the current .tex file (incl. path in the working directory). Therefore, the
## working directory for the Docker container is set to the folder of the current
## .tex file. When called directly, we need to first change-dir to this folder.
PANDOC = pandoc
HUGO   = hugo
DOT    = dot
LATEX  = cd $(dir $(realpath $<)) && latex

## Where do we find the content from https://github.com/cagix/pandoc-lecture,
## i.e. the resources for Pandoc and the themes for Hugo?
##     (a) If we run inside the Docker container, the variable CI is set to
##         true and we find the files in ${XDG_DATA_HOME}/pandoc/.
##     (b) If we are running locally (native installation), then we look for
##         the contents at ${HOME}/.local/share/pandoc/.
## Note: $(CI) is a default environment variable that GitHub sets (see
## https://docs.github.com/en/actions/learn-github-actions/variables#default-environment-variables)
ifeq ($(CI), true)
PANDOC_DIRS = --resource-path=".:$(XDG_DATA_HOME)/pandoc/:$(XDG_DATA_HOME)/pandoc/resources/"
HUGO_DIRS   = --themesDir "$(XDG_DATA_HOME)/pandoc/hugo"
else
PANDOC_DIRS = --resource-path=".:$(HOME)/.local/share/pandoc/:$(HOME)/.local/share/pandoc/resources/"
HUGO_DIRS   = --themesDir "$(HOME)/.local/share/pandoc/hugo"
endif

## Define options for generating images from ".tex" files
LATEX_ARGS = -shell-escape

## Define options for generating images from ".dot" files
DOT_ARGS = -Tpng

## Define options to be used by Hugo
## local.yaml allows to override settings in config.yaml
HUGO_LOCAL = $(wildcard local.yaml)
HUGO_ARGS  = --config config.yaml,$(HUGO_LOCAL)  $(HUGO_DIRS)

#--------------------------------------------------------------------------------
# I/O Directories
#--------------------------------------------------------------------------------

## Top level directory for source files
SRC_DIR = markdown

## Top level directory for temporary files
TEMP_DIR      = temp
HUGO_TEMP_DIR = resources
HUGO_LOCK     = .hugo_build.lock

## Top level directory for generated image files
IMAGES_OUTPUT_DIR = $(TEMP_DIR)/images

## Top level directory for temporary files used to generate website (input for Hugo)
WEB_INTERMEDIATE_DIR = $(TEMP_DIR)/content

## Top level directory for temporary files used in slides generation
SLIDES_INTERMEDIATE_DIR = $(TEMP_DIR)/slides

## Output directory generated by Hugo
WEB_OUTPUT_DIR = docs

## Output directory for generated slides
SLIDES_OUTPUT_DIR = pdf

#--------------------------------------------------------------------------------
# Helper lists
#--------------------------------------------------------------------------------

## TeX source and target files
TEX_SOURCES        = $(shell find $(SRC_DIR) -type f -iname '*.tex')
TEX_INTERMEDIATE   = $(patsubst $(SRC_DIR)/%,$(IMAGES_OUTPUT_DIR)/%, $(TEX_SOURCES))
TEX_TARGETS        = $(patsubst $(SRC_DIR)/%.tex,$(IMAGES_OUTPUT_DIR)/%.png, $(TEX_SOURCES))
WEB_TEX_TARGETS    = $(patsubst $(SRC_DIR)/%.tex,$(WEB_INTERMEDIATE_DIR)/%.png, $(TEX_SOURCES))
SLIDES_TEX_TARGETS = $(patsubst $(SRC_DIR)/%.tex,$(SLIDES_INTERMEDIATE_DIR)/%.png, $(TEX_SOURCES))

## Dot source and target files
DOT_SOURCES        = $(shell find $(SRC_DIR) -type f -iname '*.dot')
DOT_TARGETS        = $(patsubst $(SRC_DIR)/%.dot,$(IMAGES_OUTPUT_DIR)/%.png, $(DOT_SOURCES))
WEB_DOT_TARGETS    = $(patsubst $(SRC_DIR)/%.dot,$(WEB_INTERMEDIATE_DIR)/%.png, $(DOT_SOURCES))
SLIDES_DOT_TARGETS = $(patsubst $(SRC_DIR)/%.dot,$(SLIDES_INTERMEDIATE_DIR)/%.png, $(DOT_SOURCES))

## Standalone image sources and targets
STANDALONE_SOURCES         = $(shell find $(SRC_DIR) -type f -iname '*.png')
STANDALONE_TARGETS         = $(patsubst $(SRC_DIR)/%,$(IMAGES_OUTPUT_DIR)/%, $(STANDALONE_SOURCES))
WEB_STANDALONE_TARGETS     = $(patsubst $(SRC_DIR)/%,$(WEB_INTERMEDIATE_DIR)/%, $(STANDALONE_SOURCES))
SLIDES_STANDALONE_TARGETS  = $(patsubst $(SRC_DIR)/%,$(SLIDES_INTERMEDIATE_DIR)/%, $(STANDALONE_SOURCES))

## Image targets for web and slides
WEB_IMAGE_TARGETS    = $(WEB_TEX_TARGETS) $(WEB_DOT_TARGETS) $(WEB_STANDALONE_TARGETS)
SLIDES_IMAGE_TARGETS = $(SLIDES_TEX_TARGETS) $(SLIDES_DOT_TARGETS) $(SLIDES_STANDALONE_TARGETS)

## Markdown source and target files
WEB_MARKDOWN_SOURCES = $(shell find $(SRC_DIR) -type f -iname '*.md')
WEB_MARKDOWN_TARGETS = $(WEB_MARKDOWN_SOURCES:$(SRC_DIR)%=$(WEB_INTERMEDIATE_DIR)%)

## Static files for web
WEB_STATIC_SOURCES = $(shell find $(SRC_DIR) -type f \( -path '*files/*' ! -iname '.gitkeep' \))
WEB_STATIC_TARGETS = $(WEB_STATIC_SOURCES:$(SRC_DIR)%=$(WEB_INTERMEDIATE_DIR)%)

## Source and target files for slides
## NOTES:
## (1) The name for the target pdf file is generated from the relative
##     path under $(SRC_DIR) with '/' substituted by '_'.
## (2) Directories containing a .noslides file will not be considerd for slides generation.
## Directories to be excluded
SLIDES_EXCLUDE_DIRS            = $(dir $(shell find $(SRC_DIR) -type f -iname '.noslides'))
## Page-bundles
SLIDES_BUNDLE_MARKDOWN_SOURCES = $(filter-out $(addsuffix %, $(SLIDES_EXCLUDE_DIRS)), $(shell find $(SRC_DIR) -type f -iname 'index.md'))
SLIDES_BUNDLE_PDF_TARGETS      = $(addprefix $(SLIDES_OUTPUT_DIR)/,$(subst /,_, $(patsubst $(SRC_DIR)/%/index.md,%.pdf, $(SLIDES_BUNDLE_MARKDOWN_SOURCES))))
## Single markdown files
SLIDES_SINGLE_MARKDOWN_SOURCES = $(filter-out $(addsuffix %, $(SLIDES_EXCLUDE_DIRS)), $(shell find $(SRC_DIR) -type f -iname '*.md'  ! -iname '*index*.md' ! -iname 'tldr.md' ! -iname 'outcomes.md'))
SLIDES_SINGLE_PDF_TARGETS      = $(addprefix $(SLIDES_OUTPUT_DIR)/,$(subst /,_, $(patsubst $(SRC_DIR)/%.md,%.pdf, $(SLIDES_SINGLE_MARKDOWN_SOURCES))))
## Convenience targets
SLIDES_MARKDOWN_TARGETS        = $(SLIDES_BUNDLE_MARKDOWN_SOURCES:$(SRC_DIR)%=$(SLIDES_INTERMEDIATE_DIR)%) $(SLIDES_SINGLE_MARKDOWN_SOURCES:$(SRC_DIR)%=$(SLIDES_INTERMEDIATE_DIR)%)
SLIDES_SHORT_TARGETS           = $(patsubst $(SLIDES_OUTPUT_DIR)/%.pdf,%,$(SLIDES_BUNDLE_PDF_TARGETS)) $(patsubst $(SLIDES_OUTPUT_DIR)/%.pdf,%,$(SLIDES_SINGLE_PDF_TARGETS))

#--------------------------------------------------------------------------------
# Secondary Expansion
#--------------------------------------------------------------------------------

## Enable secondary expansion for subsequent targets. This allows the use
## of automatic variables like '@' in the prerequisite definitions by
## expanding twice (e.g. $$(VAR)). For normal variable references (e.g.
## $(VAR)) the expansion behaviour is unchanged as the second expansion
## has no effect on an already fully expanded reference.

.SECONDEXPANSION:

#--------------------------------------------------------------------------------
# Phony Targets
#--------------------------------------------------------------------------------

.DEFAULT_GOAL:=help

##@ Helpers

## Display help
.PHONY: help
help:  ## Display this help
	@awk 'BEGIN {FS = ":.*##"; printf "\nUsage:\n  make \033[36m\033[0m\n"} /^[a-zA-Z_-]+:.*?##/ { printf "  \033[36m%-15s\033[0m %s\n", $$1, $$2 } /^##@/ { printf "\n\033[1m%s\033[0m\n", substr($$0, 5) } ' $(MAKEFILE_LIST)

.PHONY: list-slides
list-slides: ## List available targets for individual slides
	$(foreach target,$(SLIDES_SHORT_TARGETS), $(info $(target)))
	@: ## Suppress 'Nothing to be done for ...' message

##@ Building

## Start Docker container "pandoc-lecture" into interactive shell
.PHONY: runlocal
runlocal: ## Start Docker container "pandoc-lecture" into interactive shell
	docker run  --rm -it  -v "$(shell pwd):/pandoc" -w "/pandoc"  -u "$(shell id -u):$(shell id -g)"  --entrypoint "bash"  pandoc-lecture

## Make everything
.PHONY: all
all: slides web ## Make everything

## Create all slides
.PHONY: slides
slides: $(SLIDES_BUNDLE_PDF_TARGETS) $(SLIDES_SINGLE_PDF_TARGETS) ## Create all slides

## Generate pdf slides (shortened target name for convenience)
.PHONY: $(SLIDES_SHORT_TARGETS)
$(SLIDES_SHORT_TARGETS): $$(patsubst %,$(SLIDES_OUTPUT_DIR)/%.pdf,$$@)

## Create website
.PHONY: web
web: $(WEB_MARKDOWN_TARGETS) $(WEB_IMAGE_TARGETS) $(WEB_STATIC_TARGETS) $(READINGS) $(HUGO_LOCAL) ## Create website
	$(HUGO) $(HUGO_ARGS)

## Create website and archive
.PHONY: web_zip
web_zip: web ## Create website and archive
	cd $(WEB_OUTPUT_DIR) && rm -rf site.zip && zip -r site.zip *

## Build Docker image "alpine-pandoc-hugo"
.PHONY: docker
docker: ## Build Docker image "alpine-pandoc-hugo"
	cd .github/actions/alpine-pandoc-hugo && make clean all

##@ Cleanup

.PHONY: distclean
distclean: clean ## Clean up all generated files and directories
	rm -rf $(SLIDES_OUTPUT_DIR) $(WEB_OUTPUT_DIR) $(READINGS)

.PHONY: clean
clean: ## Clean up intermediate files and directories
	rm -rf $(TEMP_DIR) $(HUGO_TEMP_DIR) $(HUGO_LOCK)

#--------------------------------------------------------------------------------
# File Targets
#--------------------------------------------------------------------------------

## Canned recipe for creating output folder
define create-folder
@mkdir -p $(dir $@)
endef

## Canned recipe for creating output folder and copy output file
define create-dir-and-copy
$(create-folder)
cp $< $@
endef

## Create readings data template
$(READINGS): $(BIBTEX)
	$(PANDOC) -s -f biblatex -t markdown $< -o $@

## Copy tex source files to $(IMAGES_OUTPUT_DIR)
## Note: This is necessary because latex generates output in the directory
##       it is called in and we do not want the $(SRC_DIR) littered with
##       temporary files.
$(TEX_INTERMEDIATE): $(IMAGES_OUTPUT_DIR)/%: $(SRC_DIR)/%
	$(create-dir-and-copy)

## Create images from tex files
$(TEX_TARGETS): %.png: %.tex
	$(LATEX) $(LATEX_ARGS) $(notdir $<)

## Create images from dot files
$(DOT_TARGETS): $(IMAGES_OUTPUT_DIR)/%.png: $(SRC_DIR)/%.dot
	$(create-folder)
	$(DOT) $(DOT_ARGS) $< -o $@

## Copy standalone images to $(IMAGES_OUTPUT_DIR)
$(STANDALONE_TARGETS): $(IMAGES_OUTPUT_DIR)/%: $(SRC_DIR)/%
	$(create-dir-and-copy)

## Copy image files to $(WEB_INTERMEDIATE_DIR)
$(WEB_IMAGE_TARGETS): $(WEB_INTERMEDIATE_DIR)/%: $(IMAGES_OUTPUT_DIR)/%
	$(create-dir-and-copy)

## Process markdown with pandoc (preprocessing for hugo)
$(WEB_MARKDOWN_TARGETS): $(WEB_INTERMEDIATE_DIR)/%: $(SRC_DIR)/%
	$(create-folder)
	$(PANDOC) $(PANDOC_DIRS) -d hugo $< -o $@

## Copy static files to $(WEB_INTERMEDIATE_DIR)
$(WEB_STATIC_TARGETS): $(WEB_INTERMEDIATE_DIR)/%: $(SRC_DIR)/%
	$(create-dir-and-copy)

## Copy image files to $(SLIDES_INTERMEDIATE_DIR)
$(SLIDES_IMAGE_TARGETS): $(SLIDES_INTERMEDIATE_DIR)/%: $(IMAGES_OUTPUT_DIR)/%
	$(create-dir-and-copy)

## Copy markdown files to $(SLIDES_INTERMEDIATE_DIR)
$(SLIDES_MARKDOWN_TARGETS): $(SLIDES_INTERMEDIATE_DIR)/%: $(SRC_DIR)/%
	$(create-dir-and-copy)

## Generate pdf slides
## Prerequisites are the lessons 'index.md' and the images in the 'images'
## subfolder.
## NOTE: The prerequisites for the images must be added after the 'index.md'
## so that '$<' contains the right input file for pandoc.
## Page-Bundles: path/name/index.md, path/name/images/, path_name.pdf
$(SLIDES_BUNDLE_PDF_TARGETS): $$(patsubst $(SLIDES_OUTPUT_DIR)/%.pdf,$(SLIDES_INTERMEDIATE_DIR)/%/index.md, $$(subst _,/,$$@))
	$(create-folder)
	$(PANDOC) $(PANDOC_DIRS) -d slides $< -o $@
$(SLIDES_BUNDLE_PDF_TARGETS): $$(filter $$(patsubst $(SLIDES_OUTPUT_DIR)/%.pdf,$(SLIDES_INTERMEDIATE_DIR)/%, $$(subst _,/,$$@))%, $(SLIDES_IMAGE_TARGETS))
## Single Markdown Files: path/name.md, path/<images>/, path_name.pdf
$(SLIDES_SINGLE_PDF_TARGETS): $$(patsubst $(SLIDES_OUTPUT_DIR)/%.pdf,$(SLIDES_INTERMEDIATE_DIR)/%.md, $$(subst _,/,$$@))
	$(create-folder)
	$(PANDOC) $(PANDOC_DIRS) -d slides $< -o $@
$(SLIDES_SINGLE_PDF_TARGETS): $$(filter $$(dir $$(patsubst $(SLIDES_OUTPUT_DIR)/%.pdf,$(SLIDES_INTERMEDIATE_DIR)/%, $$(subst _,/,$$@)))%, $(SLIDES_IMAGE_TARGETS))
